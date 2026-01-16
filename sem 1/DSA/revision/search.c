#include <stdio.h>

// -------------------- SEARCH FUNCTIONS --------------------

int linearSearch(int arr[], int n, int key) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == key)
            return i;
    }
    return -1;
}

int binarySearch(int arr[], int n, int key) {
    int low = 0, high = n - 1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        else if (arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}

// -------------------- SORTING FUNCTIONS --------------------

void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void optimizedBubbleSort(int arr[], int n) {
    int swapped;
    for (int i = 0; i < n - 1; i++) {
        swapped = 0;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = 1;
            }
        }
        if (!swapped)
            break;
    }
}

void selectionSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int min = i;

        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min])
                min = j;
        }

        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}

void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i ;

        while (j >= 0 && arr[j-1] > key) {
            arr[j ] = arr[j+1];
            j--;
        }
        arr[j] = key;
    }
}

void shellSort(int arr[], int n) {
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;

            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }
}

// -------------------- UTILITY FUNCTION --------------------

void displayArray(int arr[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

// -------------------- MAIN PROGRAM --------------------

int main() {
    int arr[100], n, choice, key, pos;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    do {
        printf("\n------ MENU ------\n");
        printf("1. Linear Search\n");
        printf("2. Binary Search\n");
        printf("3. Bubble Sort\n");
        printf("4. Optimized Bubble Sort\n");
        printf("5. Selection Sort\n");
        printf("6. Insertion Sort\n");
        printf("7. Shell Sort\n");
        printf("8. Display Array\n");
        printf("9. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("Enter element to search: ");
            scanf("%d", &key);
            pos = linearSearch(arr, n, key);
            if (pos == -1)
                printf("Element not found.\n");
            else
                printf("Element found at index %d.\n", pos);
            break;

        case 2:
            printf("Enter element to search: ");
            scanf("%d", &key);
            pos = binarySearch(arr, n, key);
            if (pos == -1)
                printf("Element not found.\n");
            else
                printf("Element found at index %d.\n", pos);
            break;

        case 3:
            bubbleSort(arr, n);
            printf("Array sorted using Bubble Sort.\n");
            break;

        case 4:
            optimizedBubbleSort(arr, n);
            printf("Array sorted using Optimized Bubble Sort.\n");
            break;

        case 5:
            selectionSort(arr, n);
            printf("Array sorted using Selection Sort.\n");
            break;

        case 6:
            insertionSort(arr, n);
            printf("Array sorted using Insertion Sort.\n");
            break;

        case 7:
            shellSort(arr, n);
            printf("Array sorted using Shell Sort.\n");
            break;

        case 8:
            printf("Array Elements: ");
            displayArray(arr, n);
            break;

        case 9:
            printf("Exiting program.\n");
            break;

        default:
            printf("Invalid choice! Try again.\n");
        }

    } while (choice != 9);

    return 0;
}
