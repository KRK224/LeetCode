<h2><a href="https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list">2903. Insert Greatest Common Divisors in Linked List</a></h2><h3>Medium</h3><hr><p>Given the head of a linked list <code>head</code>, in which each node contains an integer value.</p>

<p>Between every pair of adjacent nodes, insert a new node with a value equal to the <strong>greatest common divisor</strong> of them.</p>

<p>Return <em>the linked list after insertion</em>.</p>

<p>The <strong>greatest common divisor</strong> of two numbers is the largest positive integer that evenly divides both numbers.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/07/18/ex1_copy.png" style="width: 641px; height: 181px;" />
<pre>
<strong>Input:</strong> head = [18,6,10,3]
<strong>Output:</strong> [18,6,6,2,10,1,3]
<strong>Explanation:</strong> The 1<sup>st</sup> diagram denotes the initial linked list and the 2<sup>nd</sup> diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
- We insert the greatest common divisor of 18 and 6 = 6 between the 1<sup>st</sup> and the 2<sup>nd</sup> nodes.
- We insert the greatest common divisor of 6 and 10 = 2 between the 2<sup>nd</sup> and the 3<sup>rd</sup> nodes.
- We insert the greatest common divisor of 10 and 3 = 1 between the 3<sup>rd</sup> and the 4<sup>th</sup> nodes.
There are no more adjacent nodes, so we return the linked list.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/07/18/ex2_copy1.png" style="width: 51px; height: 191px;" />
<pre>
<strong>Input:</strong> head = [7]
<strong>Output:</strong> [7]
<strong>Explanation:</strong> The 1<sup>st</sup> diagram denotes the initial linked list and the 2<sup>nd</sup> diagram denotes the linked list after inserting the new nodes.
There are no pairs of adjacent nodes, so we return the initial linked list.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 5000]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 1000</code></li>
</ul>


<h3>Note</h3>
<hr>

<h4>해결 과정</h4>
<strong>유클리드 호제법</strong>
<ul>
<li>두 수 a,b의 최대공약수는 a를 b로 나눈 나머지 r과 b의 최대공약수와 같다.</li>
<li>gcd(a,b) = gcd(b,r)</li>
</ul>

<p> 
<strong>증명</strong>

a = bq + r, a = Ga', b = Gb'(a'와 b'는 서로소) 일 때, r에 대해서 풀어쓰면,

r = a - bq = Ga' - Gb'q = G(a' - b'q), 여기서 가정이 성립하려면 (a'-b'q) 가 b'와 서로소 관계이면 된다.

<strong>이를 귀류법으로 증명하자</strong>.

만약 a' - b'q 와 b'가 서로소가 아닌 경우라 가정하면 다음과 같다. (최대 공약수 k라 가정)
<ul>
<li>a' - b'q = mk</li>
<li>b' = nk</li>
=> a' = mk + b'q = mk + nqk = k(m+nq) => a'와 b'가 서로소라는 기존의 명제에 모순이 발생한다.
</ul>

따라서, gcd(a,b) = gcd(b,r)가 성립한다.

<h4>문제점</h4>
<ul>
<li>구현 중에 새로운 LinkedNode를 구현하는데 next로 head.next를 사용했었다.</li>
<li>그러면 gcd를 삽입하는 과정에서 기존의 head 노드가 참조되어 무한 루프 발생...</li>
</ul>

<h4>개선할 점</h4>
<ul>
</ul>

<h4>알게 된 점</h4>
<ul>
<li>유클리드 호제법 증명과 최소공배수(a*b/gcd(a,b)), 최대공약수(gcd(a,b))</li>
<li>시간복잡도를 계산해보면 둘 중 작은수의 log값이지 않을까??</li>
</ul>
