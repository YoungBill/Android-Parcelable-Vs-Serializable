# Android-Parcelable-Vs-Serializable
A Sample for Android Parcelable-Vs-Serializable
### 总结
#### 什么叫序列化，什么叫反序列化
序列化： 将数据结构或对象转换成二进制串的过程。
<br/>反序列化：将在序列化过程中所生成的二进制串转换成数据结构或者对象的过程。
<br/>简单来说，序列化就是将我们生成的对象进行存储起来（比如磁盘上），以用来将来使用或者在网络上进行传输，而反序列化呢，就是由我们的之前序列化生成的二进制串重新生成对象的过程。注意，这里我们反复说的序列化啦，反序列化啦，都是针对的对象，而非类。因为我们是针对对象进行存取与传输的，而非类，当我们需要重新获取之前的对象的时候，是直接读取出来的（从文件或网络中），而非根据类new出一个对象，这点是需要注意的。
#### 如何序列化
序列话的方式有两种，一种是实现Serializable接口，一种是实现Parceable接口。
#### 实现要点
1.实现Serializable接口
这种序列化方式是Java提供的，它的优点是简单，其实Serializable接口是个空接口，因而我们并不需要实现什么抽象方法，但是我们却往往需要在类中声明一个静态变量标识（serialVersionUID），但这不是必须的，我们不声明，依然可以实现序列化，但是这样的话会对反序列化产生一定的影响，可能会在我们对类做了修改之后而造成对象的反序列化失败。
2.实现Parceable接口
<br/>需要实现三个东西：
<br>1）writeToParcel 方法。该方法将类的数据写入外部提供的Parcel中.声明如下：
<br>writeToParcel (Parcel dest, int flags) 具体参数含义见javadoc
<br>2）describeContents方法。没搞懂有什么用，反正直接返回0也可以
<br>3）静态的Parcelable.Creator接口，本接口有两个方法：
<br>createFromParcel(Parcel in) 实现从in中创建出类的实例的功能
<br>newArray(int size) 创建一个类型为T，长度为size的数组，仅一句话（return new T[size])即可。本方法是供外部类反序列化本类数组使用。
#### Serializable与Parcelable区别
虽然两者都是用于支持序列化、反序列化话操作，但是两者最大的区别在于存储媒介的不同，Serializable是将序列化后的对象存储在硬盘上，使用I/O读写的方式，而Parcelable是将其存储在内存中，是针对内存的读写，熟悉计算机组成原理的朋友都知道，内存的读写速度显然要远远大于I/O的读写速度，这也是为什么Android中推荐使用Parcelable这种方式来实现对象的序列化。
#### 注意
Parcelable 中，我们无法直接写入boolean值，而是将其转化为整数值进行保存，这里为Byte当然，你也可以使用 Int 等。
#### 性能对比
http://www.developerphil.com/parcelable-vs-serializable/