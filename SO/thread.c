#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>


#define NUMBER_OF_THREADS 10

void *print_hello_world(void *threadId){
    printf("Hello thread %d !!!\n", threadId);
    pthread_exit(NULL);
}


int main(int argc, char *argv[]){
    pthread_t threads[NUMBER_OF_THREADS];

    int status, index;

    for(index = 0 ; index < NUMBER_OF_THREADS; index++){
        printf("Creating new thread...\n");
        status = pthread_create(&threads[index],
        NULL, print_hello_world, (void *) index);

        if(status != 0){
            printf("Something went wrong...\nStatus error: %d\n" ,status);
            exit(-1);
        }
    }
    return 0;
}