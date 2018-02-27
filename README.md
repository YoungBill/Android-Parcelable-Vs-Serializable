# Android-Parcelable-Vs-Serializable
A Sample for Android Parcelable-Vs-Serializable

### 总结
#### Parcelable实现要点
需要实现三个东西：
<br>1）writeToParcel 方法。该方法将类的数据写入外部提供的Parcel中.声明如下：
<br>writeToParcel (Parcel dest, int flags) 具体参数含义见javadoc
<br>2）describeContents方法。没搞懂有什么用，反正直接返回0也可以
<br>3）静态的Parcelable.Creator接口，本接口有两个方法：
<br>createFromParcel(Parcel in) 实现从in中创建出类的实例的功能
<br>newArray(int size) 创建一个类型为T，长度为size的数组，仅一句话（return new T[size])即可。本方法是供外部类反序列化本类数组使用。
