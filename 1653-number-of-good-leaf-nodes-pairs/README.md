<h2><a href="https://leetcode.com/problems/number-of-good-leaf-nodes-pairs">1653. Number of Good Leaf Nodes Pairs</a></h2><h3>Medium</h3><hr><p>You are given the <code>root</code> of a binary tree and an integer <code>distance</code>. A pair of two different <strong>leaf</strong> nodes of a binary tree is said to be good if the length of <strong>the shortest path</strong> between them is less than or equal to <code>distance</code>.</p>

<p>Return <em>the number of good leaf node pairs</em> in the tree.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/07/09/e1.jpg" style="width: 250px; height: 250px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,null,4], distance = 3
<strong>Output:</strong> 1
<strong>Explanation:</strong> The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/07/09/e2.jpg" style="width: 250px; height: 182px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6,7], distance = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
<strong>Output:</strong> 1
<strong>Explanation:</strong> The only good pair is [2,5].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the <code>tree</code> is in the range <code>[1, 2<sup>10</sup>].</code></li>
	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
	<li><code>1 &lt;= distance &lt;= 10</code></li>
</ul>

<p>&nbsp;</p>
<h3>접근 과정</h3>
<hr>
<p>
<strong><b>성공 여부: 실패</b></strong>
</p>
<p>
처음 접근: leaf node까지의 거리는 root 노드에서부터의 레벨이다. 그럼 각 leaf의 level만 기록해놓으면 되지 않을까?

문제: root 기준으로의 레벨로 하면 결국 부모가 다른 leaf 노드만 계산할 수 있다. => 해결 방안 찾지 못함...

해설: root 기준이 아닌 현재 노드 기준으로 leaf node와 레벨을 저장한다. 단 순회 순서를 후위 순회로 하여 현재 노드의 leaf node까지의 거리와 개수를 구한다.
<h4> 주의할 점 </h4>
현재 노드를 기준으로 한 각 거리 별 leaf Node 쌍을 계산하는 것이 아니고, 자식 노드를 기준으로 거리 계산(2+d1+d2) 한 leat 쌍을 계산(left[d1] * left[d2])한다.

<strong><b>=> 처음엔 자식 노드의 leaf node 개수를 거리를 1씩 shift하여 현재 노드로 옮겨 계산하면 +2 안하고 편하지 않나? 생각했지만... left, right 구분이 있어야지만 중복 계산이 이뤄지지 않는다!</b></strong> 
</p>