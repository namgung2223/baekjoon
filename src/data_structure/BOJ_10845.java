package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845 {

    /*
문제
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

예제 입력 1
15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty

    * */
    public static void main(String[] args) throws IOException {
        Queue10845 que = new Queue10845();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(1<= N && N <= 10000){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                switch (order){
                    case "push" :
                        int value = Integer.parseInt(st.nextToken());
                        que.push(value);
                        break;
                    case "front" :
                        sb.append(que.front()).append("\n");
                        break;
                    case "back" :
                        sb.append(que.back()).append("\n");
                        break;
                    case "size" :
                        sb.append(que.size()).append("\n");
                        break;
                    case "pop" :
                        sb.append(que.pop()).append("\n");
                        break;
                    case "empty" :
                        sb.append(que.empty()).append("\n");
                        break;
                }
            }
            System.out.println(sb);
        }

    }

    static class Queue10845{
        private Queue<Integer> queue;
        private int lastVal = 0;

        public Queue10845() {
            queue = new LinkedList<>();
        }

            public Integer push(Integer integer) {
                lastVal = integer;
                queue.add(lastVal);
                return lastVal;
            }

            public Integer pop() {
                if(queue.isEmpty()) return -1;
                else return queue.poll();
            }

            public Integer size() {return queue.size();}

            public Integer empty() {
                if(queue.isEmpty()) return 1;
                else return 0;
            }

            public Integer front(){
                if(queue.peek() == null) return -1;
                else return queue.peek();
            }

            public Integer back(){
                if(queue.isEmpty()) return -1;
                else return lastVal;
            }
    }
}
