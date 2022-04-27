/**
 * A class that implements a queue of objects by using an array.
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
    // Private data fields
    private T[] queue; // Circular array of queue entries and one unused element
    private int frontIndex;
    private int backIndex;
    private boolean integrityOK;
    private static final int DEFUALT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayQueue() {
        this(DEFUALT_CAPACITY);
    } // End default constructor

    public ArrayQueue(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);

        // Case the array of null objects to array of T null objects
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        integrityOK = true;
    } // end constructor

    @Override
    public void enqueue(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    } // end enqueue

    @Override
    public T dequeue()
    {
        checkIntegrity();
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            T oldFront = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return oldFront;
        }
    }

    @Override
    public T getFront()
    {
        checkIntegrity();
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            return queue[frontIndex];
        }
    }

    @Override
    public boolean isEmpty()
    {
        checkIntegrity();
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    @Override
    public void clear()
    {
        checkIntegrity();
        while (!isEmpty())
        {
            dequeue();
        }

    }

    // Doubles the size of the array queue if it is full.
    // Precondition: checkIntegrity has been called
    private void ensureCapacity()
    {
        if (frontIndex == ((backIndex + 2) % queue.length)) // if array is full
        {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize - 1);  // Since we leave one empty space
            integrityOK = false;

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++ )
            {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
            integrityOK = true;
        }
    } // end ensureCapacity

    // Throws an exception if this object is not initialized.
    private void checkIntegrity()
    {
        if (!integrityOK)
        {
            throw new SecurityException("Queue object is corrupt. ");
        }
    } // end checkIntegrity

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum of " +
                    MAX_CAPACITY);
        }
    } // End checkCapacity

}
