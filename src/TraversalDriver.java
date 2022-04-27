public class TraversalDriver
{
    public static void main(String[] args)
    {
        QueueInterface<String> myQueue = new ArrayQueue<>();
        myQueue.enqueue("alan");
        myQueue.enqueue("aldo");
        myQueue.enqueue("aram");
        myQueue.enqueue("adriel");

        myQueue.dequeue();

        System.out.println("Front is: " + myQueue.getFront());
        myQueue.clear();
        System.out.println();

    }


}
