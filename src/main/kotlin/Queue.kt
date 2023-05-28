interface Queue<T> {
    fun enqueue(item: T)
    fun dequeue():T?
    val isEmpty: Boolean
}

class MHQueue<T> : Queue<T>{
    internal data class Node<T>(val value: T, var next:Node<T>?=null)
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override fun enqueue(item: T) {
        val newNode = Node(item)
        if (isEmpty) {
            head = newNode
            tail = newNode
        } else {
            tail!!.next = newNode
            tail = newNode
        }
    }
    override fun dequeue(): T? {
        val oldHead = head
        if(!isEmpty){
            head = oldHead?.next
        } else {
            head = null
            tail = null
        }
        return oldHead?.value
    }

    override val isEmpty: Boolean
        get() = head == null

}
