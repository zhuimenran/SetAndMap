#散列表
转载https://www.cnblogs.com/skywang12345/p/3311915.html
##O（1）模型
通过这个模型我们知道，要想达成 O(1) 复杂度的查找，必须满足3个条件：
1. 存储单元（例如一页纸）中存储的内容（例如大写数字）与存储单元的地址（例如页码）必须是一一对应的。
2. 这种一一对应的关系（例如大写数字“柒”在第7页）必须是可以预先知道的。
3. 存储单元是可以随机读取的。这里“随机读取”的意思是可以以任意的顺序读取每个存储单元，并且每次读取所需时间都是相同的。
转载#https://www.cnblogs.com/skywang12345/p/3311899.html

##在计算机上实现 O(1) 查找

###1，先来看计算机的硬件设备。计算机的内存支持随机存取，从它的名字 RAM(random-access memory) 可以看得出对于
这一点它还真有一点引以为傲呢。
既然硬件支持，我们就可以准备在计算机上模拟会计专业字帖了。第一项任务是向操作系统申请9个存储单元。
这里有个小问题，我们得到的存储单元的地址很可能并不是从1到9，而是从134456开始的。
好在我们并不需要直接跟操作系统打交道，高级语言会为我们搞定这些琐事。当我们使用高级语言创建一个数组时，
相当于申请了一块连续的存储空间，数组的下标是每个存储单元（抽象）的地址。这样我们第一个 O(1) 复杂度的容器 
###2，新需求！同样只需要保存10个数字，只不过这次不是保存0～9，而是需要保存10～19，怎么办？
很简单，实现一个槽里的值与地址的映射函数 H() 
###3，还是存储10个数字，只不过数字的范围是0～19。如何把20个数字存放到10个槽里？
还能怎么办，2人住1间咯。略微修改一下 H() 函数，其它代码不变。
2人住1间是行不通的，数据受不了这委屈。但是米有办法，除非 1) 我们预先知道所有的10个输入；2) 这10个输入一旦决定就不再更改，
否则无论怎么设计 H() 函数都无法避免2人住一间的情况，这时我们就说发生了碰撞（collision）。
###4，处理碰撞
处理碰撞最简单的一个办法是链接法(chaining)。链接法就是让发生碰撞的2人住2间，但是共用1个公共地址。
为了简单起见，可以让数组的每个槽都指向一个链表。

#散列法
除法散列法，乘法散列法

#使用开放寻址法处理碰撞

不用额外的链表，以及任何其它额外的数据结构，就只用一个数组，在发生碰撞的时候怎么办呢？答案只能是，再找另一个空着的槽啦！这就是开放寻址法(open addressing)。但是这样难道不是很不负责任的吗？想象一下，有一趟对号入座的火车，假设它只有一节车厢，上来一位坐7号座位的旅客。
过了一会儿，又上来一位旅客，他买到的是一张假票，也是7号座位，这时怎么办呢？
列车长想了想，让拿假票的旅客去坐8号座位。过了一会儿，应该坐8号座位的旅客上来了，
那你去坐11号吧。可以想见，越到后来，当空座越来越少时，碰撞的几率就越大，寻找空座愈发地费劲。
但是，如果是火车的上座率只有50%或者更少的情况呢？也许真正坐8号座位的乘客永远不会上车，
那么让拿假票的乘客坐8号座位就是一个很好的策略了。所以，这是一个空间换时间的游戏。
玩好这个游戏的关键是，让旅客分散地坐在车厢里。如何才能做到这一点呢？
答案是，对于每位不同的旅客使用不同的探查序列。例如，对于旅客 A，探查座位 7，8，23，56……直到找到一个空位；
对于旅客B，探查座位 25，66，77，1，3……直到找到一个空位。
如果有 m 个座位，每位旅客可以使用 <0, 1, 2, ..., m-1> 的 m! 个排列中的一个。
显而易见，最好减少两个旅客使用相同的探查序列的情况。
也就是说，希望把每位旅客尽量分散地映射到 m! 种探查序列上。
换句话说，理想状态下，如果能够让每个上车的旅客，
使用 m! 个探查序列中的任意一个的可能性是相同的，我们就说实现了一致散列。（
这里没有用“随机”这个词儿，因为实际是不可能随机取一个探查序列的，因为在查找这名旅客时还要使用相同的探查序列）。
真正的一致散列是难以实现的，实践中，常常采用它的一些近似方法。
常用的产生探查序列的方法有：线性探查，二次探查，以及双重探查。
这些方法都不能实现一致散列，因为它们能产生的不同探查序列数都不超过 m2 个（一致散列要求有 m! 个探查序列）。
在这三种方法中，双重散列能产生的探查序列数最多，因而能给出最好的结果（注：.net framework 的 HashTable 就是使用的双重散列法）。
实现了一个函数 h(k)，它的任务是把数值 k 映射为一个数组（尽量分散）的地址。
这次，我们使用开发寻找法，需要实现一个函数 h(k, i)，它的任务是把数值 k 映射为一个地址序列，
序列的第一个地址是 h(k, 0)，第二个地址是 h(k, 1)……序列中的每个地址都要尽可能的分散。

##线性探查（linear probing）线性探查法虽然比较容易实现，但是它有一个叫做一次群集（primary clustering）的问题

##二次探查（quadratic probing）让这个偏移量依赖 i 的平方：
　　h(k, i) = (h'(k) + c1i + c2i2) mod m
但是，由于只要探查的初始位置相同，探查序列就会完全相同，所以会连成一小片、一小片的，这一性质导致一种程度较轻的群集现象，称为二次群集（secondary clusering）。

###双重散列

造成线性探查法和二次探查法的群集现象的罪魁祸首是一旦初始探查位置相同，整个探查序列就相同。这样，一旦出现碰撞，事情就会变得更糟。是什么造成一旦初始探查位置相同，整个探查序列就相同呢？是因为线性探查法和二次探查法都是让后续的探查位置基于初始探查位置（即 H(k)）向后偏移几个位置，而这个偏移量，不管是线性的还是二次的，都仅仅是 i 的函数，但是只有 k 是不同的对不对？所以必须想办法让偏移量是 k 的函数才行。以线性探查为例，要想办法让 LH(k, i) 是 k 和 i 的函数，而不是 H(k) 和 i 的函数。说干就干，我们试着把线性探查
H(k) = k % 10
LH(k, i) = (H(k) + i) % 10
改造一下，先试试把 k 乘到 i 上面去，即
H(k) = k % 10
LH(k, i) = (H(k) + i * k) % 10
这有效果吗？很不幸，
LH(k, i) = (H(k) + i * k) % 10
           = (H(k) + i * (k%10) % 10
           = (H(k) + i * H(k)) % 10
           = (H(k) * (1 + i)) % 10
结果 LH(k, i) 还是 H(k) 和 i 的函数。
再试试把 k 加到 i 上，即
H(k) = k % 10
LH(k, i) = (H(k) + i + k) % 10
这个怎么样？
LH(k, i) = (H(k) + i + k) % 10
           = (H(k) + i + k%10) % 10
           = (H(k) + i + H(k)) % 10
           = (2*H(k) + i) % 10
太不幸了，LH(k) 仍然是 H(k) 和 i 的函数。好像怎么折腾都不行，除非把 H(K) 变成乘法散列法，或者使用双重散列(double hashing)法：
h(k, i) = (h1(k) + i*h2(k)) mod m
其中 h1(k) 和 h2(k) 是两个不同的散列函数。例如可以让
h1(k) = k mod 13
h2(k) = k mod 11
h(k, i) = (h1(k) + i*h2(k)) mod 10
这样，h(7, i) 产生的探查序列是 7、4、1、8、5……
h(20, i) 产生的探查序列是 7、6、5、4、3……
这回终于达到了初始探查位置相同，但是后续探查位置不同的目标。
　　h2(k) 的设计很有讲究，搞不好会无法探查到每个空槽。以刚刚实现的 h(k, i) 为例，h(6, i) 的探查序列是“6、2、8、4、0、6、2、8、4、0”，如果恰巧数组中的“6、2、8、4、0”这几个位置都被占用了，将会导致程序在还有空槽的状态下抛出“集合溢出”的异常。要避免这种情况，要求 h2(k) 与 m 必须互质。可以看一看如果 h2(k) 与 m 不是互质的话，为什么会有无法探查数组的所有的槽的后果。例如 h2(6)=6 与 10 有公约数2，把它们代入 h(k, i)：
h(6, i) = (h1(6) + i * h2(6)) mod 10
          = (6 + i * 6) mod 10
          = (6 + (i * 6) mod 10) mod 10
          = (6 + 2*((i*6) mod 5)) mod 10
          
  由于 (i*6) mod 5) 只有 5 个不同的值，所以 h(6, i) 也只有 5 个值。而 h(16, i) = (3 + 5*((i*5) mod 2)) mod 10 只有2个值，真是太糟糕了。
要想让 h2(k) 与 m 互质，有2种方法。一种方法是让 m 为 2 的幂，并且设计一个总是产生奇数的 h2(k)，利用的是奇数和 2 的 m 次幂总是互质的原理。另一种方法是让 m 为质数，并设计一个总是产生比 m 小的正整数的 h2(k)。可以这么实现后一种方法：首先使用上一篇实现的 GetPrime() 函数取得一个合适的质数作为 m，然后让
h1(k) = k mod m
h2(k) = 1 + (k mod (m-1))
在 h2(k) 里之所以要把 (k mod (m-1)) 加上个 1 是为了让 h2(k) 永不为0。因为 h2(k) 为 0 会让 i 不起作用，一旦正巧 h1(k) 产生碰撞就无法取得下一个空槽了。