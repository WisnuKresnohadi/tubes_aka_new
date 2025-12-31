public class HeapSortRecur {

    void heapify(int arr[], int n, int i) {
        int largest = i;       // Set largest as root
        int l = 2 * i + 1;     // left child
        int r = 2 * i + 2;     // right child

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        HeapSortRecur ob = new HeapSortRecur();
        int[] a = Array1.data;   
        long start = System.currentTimeMillis();
        ob.heapSort(a);
        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println();
        System.out.println("Heap Sort (Iteratif) Selesai");
        System.out.println("Waktu Eksekusi: " + duration + " ms (" + (duration / 1_000.0) + " s)");
    }
}
