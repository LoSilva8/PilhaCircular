public class QueueCircular<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;
    private int size;

    public QueueCircular(int size) {
        this.size = size;
        data = (T[]) new Object[size]; // Tamanho
    }

    // Adicionar elemento
    public void add(T item) {
        if (isFull()) {
            System.out.println("Queue cheia."); 
            return;
        }
        top = move(top); // Move topo para proxima pos
        data[top] = item; // Adiciona item na queue
    }

    // Removendo elemento
    public T remove() {
        if (isEmpty()) {
            System.out.println("Queue vazia.");
            return null;
        }
        T itemRemovido = data[base]; // Item do index base
        data[base] = null; // Limpa base
        base = move(base); // Index base para prox pos
        if (base == move(top)) {
            top = -1;
            base = 0;
        }
        return itemRemovido;
    }

    public void clear() {
        top = -1;
        base = 0;
        data = (T[]) new Object[size];
    }

    public boolean isFull() {
        return move(top) == base && data[base] != null; // Se topo for base e base nao nula
    }

    public boolean isEmpty() {
        return top == -1; // Se top == -1 queue vazia
    }

    // Metodo que mexe index para proxima pos
    private int move(int position) {
        return (position + 1) % size; 
    }

    public static void main(String[] args) {
        QueueCircular<Integer> queue = new QueueCircular<>(5);

        queue.add(1); 
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove()); // remove e printa primeiro elemento
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}