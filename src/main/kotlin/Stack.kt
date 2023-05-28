interface Stack<T> {
    fun push(item: T)
    fun top(): T?
    fun pop() : T?
    fun count(): Int
    fun empty()
}

class MHStack<T>:Stack<T> {
    private data class Node<T>(val value:T, var next:Node<T>? = null)
    private var head: Node<T>? = null
    private var count = 0

    override fun top(): T? = head?.value
    override fun count(): Int = count

    override fun push(item: T) {
        count++
        val newNode = Node(item, head)
        head = newNode
    }
    override fun pop(): T? {
        val oldHead = head
        if(count > 0){
            count--
            head = oldHead!!.next
        }
        return oldHead?.value
    }
    override fun empty() {
        while (count > 0) pop()
    }
}
