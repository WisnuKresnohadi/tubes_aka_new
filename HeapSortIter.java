public class HeapSortIter {

    void heapifyIterative(int arr[], int n, int i) {
        int largest = i;

        while (true) {
            int l = 2 * largest + 1;  // left child
            int r = 2 * largest + 2;  // right child
            int max = largest;

            // Cek anak kiri
            if (l < n && arr[l] > arr[max])
                max = l;

            // Cek anak kanan
            if (r < n && arr[r] > arr[max])
                max = r;

            // Jika largest masih root (i), berarti tidak perlu swap
            if (max == largest)
                break;

            // Swap
            int temp = arr[largest];
            arr[largest] = arr[max];
            arr[max] = temp;

            // Pindah ke subtree berikutnya
            largest = max;
        }
    }

    void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyIterative(arr, n, i);

        // Extract element from heap
        for (int i = n - 1; i > 0; i--) {
            // Pindahkan root ke akhir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify pada sisa elemen dengan iteratif
            heapifyIterative(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        HeapSortIter ob = new HeapSortIter();
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
