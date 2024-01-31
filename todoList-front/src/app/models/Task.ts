enum taskState{
    TODO,
    DONE
}
export interface Task{
    index: number;
    title: string;
    description: string;
    state: taskState
    isDone: boolean;
}