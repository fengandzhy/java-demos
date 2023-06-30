package org.frank.java;


/**
 * 1. 当一个对象实现Serializable 的时候, 它就可以被写到ObjectOutputStream 里面, 如果这个ObjectOutputStream 是由FileOutputStream来
 * 构造的话, 那么这个对象就可以写到 file中. 可以用ObjectInputStream来恢复这个对象
 * 
 * 2. 如果父类实现了Serializable接口, 则子类也就自动实现这个接口了
 * 
 * 3. 当一个字段被标记上transient 时它就无法实现序列化, 自然也就无法通过ObjectOutputStream来保存到文件中, 也无法恢复
 * 
 * 4. 当一个字段被标记上transient 但同时还想写入文件中时, 就要在原本的类中加入 writeObject 和 readObject 这些方法必须是私有的
 * 在这些方法里手动加入write 和 read方法, 参看本例的User
 * 
 * 5. 如果一个类当中引用了不能序列化的类, 例如在Student里面引用了Classroom, 虽然Student 实现了Serializable, 但是Classroom 没有
 * 实现Serializable 所以你要把Student 写入流就会报错. 给classroom 加入transient 就不会报错了, 
 * 
 * 6. 在原有类中加入私有的 writeObject 和 readObject的时候 也要保证写入和读取的是实现Serializable 接口的, 例如直接写入 
 * oos.writeObject(classroom); 就会报错, 因为Classroom 没有实现序列化, 但是这样写入oos.writeObject(classroom.getId());
 * 就正确了, 因为Integer 是实现Serializable 的
 * 
 * 7. 根据java虚拟机的内存模型，我们知道其中规定了：共享变量存储在主内存(Main Memory)中，
 * 每个线程都有一个私有的本地内存（Local Memory），本地内存保存了被该线程使用到的主内存的副本拷贝，
 * 线程对变量的所有操作都必须在工作内存中进行，而不能直接读写主内存中的变量。
 * 
 * 8. 一是保证共享变量对所有线程的可见性；所谓可见性，就是指当一个线程修改了这个共享变量的值，可以立即同步到主存，每次使用前从主存刷新。
 * 
 * 
 * */
public class Test {
    public static void main(String[] args) {
        
    }
}
