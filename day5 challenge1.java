#include <stdio.h>

void sort(int arr[], int n, int ascending) {
 for (int i = 0; i < n-1; i++)
for (int j = i+1; j < n; j++)
if ((ascending && arr[i] > arr[j]) || (!ascending && arr[i] < arr[j])) {
int temp = arr[i];
 arr[i] = arr[j];
arr[j] = temp;
}
}

void printArray(int arr[], int n) 
{
for (int i = 0; i < n; i++) printf("%d ", arr[i]);
 printf("\n");
}

int main() 
{
 int arr[] = {7, 2, 9, 1, 4, 10, 15, 8, 6, 2, 5};
 int n = sizeof(arr)/sizeof(arr[0]);
    
 int asc[11], desc[11];
 for (int i = 0; i < n; i++) asc[i] = desc[i] = arr[i];

 sort(asc, n, 1);
 sort(desc, n, 0);

    printf("Ascending Order:\n");
printArray(asc, n);
printf("Descending Order:\n");
printArray(desc, n);

return 0;
}
