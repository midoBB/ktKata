import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

internal class MHStackTest{
    private lateinit var stack: Stack<Int>

    @BeforeEach
    fun setUp() {
        stack = MHStack()
    }

    @Test
    fun testPushAndTop() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.top())
    }

    @Test
    fun testPop() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        val poppedItem = stack.pop()
        assertEquals(3, poppedItem)
        assertEquals(2, stack.count())
    }

    @Test
    fun testPopOnEmptyStack() {
        val poppedItem = stack.pop()
        assertNull(poppedItem)
        assertEquals(0, stack.count())
    }

    @Test
    fun testCount() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.count())

        stack.pop()
        assertEquals(2, stack.count())
    }

    @Test
    fun testEmpty() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        stack.empty()
        assertEquals(0, stack.count())
        assertNull(stack.top())
    }
}
