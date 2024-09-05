<h2><a href="https://leetcode.com/problems/walking-robot-simulation">906. Walking Robot
Simulation</a></h2><h3>Medium</h3><hr><p>A robot on an infinite XY-plane starts at point <code>(0,
0)</code> facing north. The robot can receive a sequence of these three possible types of <code>
commands</code>:</p>

<ul>
	<li><code>-2</code>: Turn left <code>90</code> degrees.</li>
	<li><code>-1</code>: Turn right <code>90</code> degrees.</li>
	<li><code>1 &lt;= k &lt;= 9</code>: Move forward <code>k</code> units, one unit at a time.</li>
</ul>

<p>Some of the grid squares are <code>obstacles</code>. The <code>i<sup>th</sup></code> obstacle is at grid point <code>obstacles[i] = (x<sub>i</sub>, y<sub>i</sub>)</code>. If the robot runs into an obstacle, then it will instead stay in its current location and move on to the next command.</p>

<p>Return <em>the <strong>maximum Euclidean distance</strong> that the robot ever gets from the origin <strong>squared</strong> (i.e. if the distance is </em><code>5</code><em>, return </em><code>25</code><em>)</em>.</p>

<p><strong>Note:</strong></p>

<ul>
	<li>North means +Y direction.</li>
	<li>East means +X direction.</li>
	<li>South means -Y direction.</li>
	<li>West means -X direction.</li>
	<li>There can be obstacle in&nbsp;[0,0].</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> commands = [4,-1,3], obstacles = []
<strong>Output:</strong> 25
<strong>Explanation:</strong> The robot starts at (0, 0):
1. Move north 4 units to (0, 4).
2. Turn right.
3. Move east 3 units to (3, 4).
The furthest point the robot ever gets from the origin is (3, 4), which squared is 3<sup>2</sup> + 4<sup>2</sup> = 25 units away.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> commands = [4,-1,4,-2,4], obstacles = [[2,4]]
<strong>Output:</strong> 65
<strong>Explanation:</strong> The robot starts at (0, 0):
1. Move north 4 units to (0, 4).
2. Turn right.
3. Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
4. Turn left.
5. Move north 4 units to (1, 8).
The furthest point the robot ever gets from the origin is (1, 8), which squared is 1<sup>2</sup> + 8<sup>2</sup> = 65 units away.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> commands = [6,-1,-1,6], obstacles = []
<strong>Output:</strong> 36
<strong>Explanation:</strong> The robot starts at (0, 0):
1. Move north 6 units to (0, 6).
2. Turn right.
3. Turn right.
4. Move south 6 units to (0, 0).
The furthest point the robot ever gets from the origin is (0, 6), which squared is 6<sup>2</sup> = 36 units away.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= commands.length &lt;= 10<sup>4</sup></code></li>
	<li><code>commands[i]</code> is either <code>-2</code>, <code>-1</code>, or an integer in the range <code>[1, 9]</code>.</li>
	<li><code>0 &lt;= obstacles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-3 * 10<sup>4</sup> &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 3 * 10<sup>4</sup></code></li>
	<li>The answer is guaranteed to be less than <code>2<sup>31</sup></code>.</li>
</ul>

<h3>Note</h3>
<hr>
<h4>해결 과정</h4>
<ul>
<li>처음 문제를 접했을 때 떠오른 생각은 각 장애물의 위치를 각각 x,y에 정사형하자는 생각.</li>
<li>로봇은 x,y 둘 중 한 축은 고정하고 다른 한 축으로 이동할 수 있기 때문에 떠올린 생각.</li>
<li>그래서 현재 움직이는 방향을 결정하고 최종 목적지까지 가는 도중에 장애물이 있는지 확인하는 Map 구조 사용</li>
</ul>

<h4>문제점</h4>
<ul>
<li>디버깅에 오랜 시간을 소요했는데, 그 이유는 임계값(목적지와 장애물이 일치하는 경우)를 조건에 고려하지 않았기 때문...</li>
</ul>

<h4>개선할 점</h4>
<ul>
    <li>방향 설정 int(0~3)로 저장하고 이동값을 2차원 배열로 지정하는 방식은 자주 쓰일 것 같다.</li>
    <li>그리고 우회전, 좌회전을 현재 방향 값에 (+1 or +3) % 4 하는 것도 기억할 것</li>
</ul>

<h4>알게 된 점</h4>
<ul>
<li>풀이에서는 로봇의 이동을 한칸씩 수행하고 수행 전 장애물의 위치인지 HashSet을 통해 알아본다.</li>
<li>이 방법을 사용하기 위해 Hash함수를 만드는데 x1 + HASH_CONSTANT * y 이고, HASH_CONSTANT가 x, y의 범위를 넘어선 <strong>소수 라는 점</strong></li>
<li>그런데 굳이 소수일 필요가 있나? x,y의 범위의 2배로 설정하면(+- 3*10^4 => 60002) 절대 겹칠일 이 없을 텐데?</li>
<li> x1 + HC * y1 = x2 + HC*y2 (충돌 상황)이 성립하는 경우를 증명하면 (x1-x2) = HC * (y2 - y1) 인데 x1-x2의 최대 값은 60000이고, HC가 60002이면 y2와 y1이 1차이가 나도 다르다..</li>
<li>아무튼 해시 함수를 이용하여 고유값을 계산해 내는 것이 인상 깊었다</li>
</ul>