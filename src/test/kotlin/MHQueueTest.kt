import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MHQueueTest{

    private lateinit var queue: Queue<Int>

    @BeforeEach
    fun setUp() {
        queue = MHQueue()
    }

    @Test
    fun testEnqueueAndDequeue() {
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)

        assertEquals(1, queue.dequeue())
        assertEquals(2, queue.dequeue())
        assertEquals(3, queue.dequeue())
        assertNull(queue.dequeue())
        assertTrue(queue.isEmpty)
    }

    @Test
    fun testIsEmpty() {
        assertTrue(queue.isEmpty)

        queue.enqueue(1)
        assertFalse(queue.isEmpty)

        queue.dequeue()
        assertTrue(queue.isEmpty)
    }
}
