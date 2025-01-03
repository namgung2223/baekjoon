package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966 {
    static LinkedList<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            // 문서 개수
            int N = Integer.parseInt(st.nextToken());
            // 몇 번째로 인쇄 되는지
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            sb.append(getNumber(M)).append("\n");
        }
        System.out.println(sb);
    }

    static int getNumber(int M){
        //몇번째로 인쇄 되었는지 저장할 변수
        int number = 0;

        //큐가 비었을때까지 반복
        while(!queue.isEmpty()){
            //큐의 맨 앞 요소
            int[] X = queue.poll();
            //가장 큰 요소인지 참/거짓
            boolean check = true;

            for(int i = 0; i < queue.size(); i++){
                //맨 앞 요소(X) 보다 큰 요소 존재 확인
                int i1 = queue.get(i)[1];
                if(X[1] < i1){
                    //X를 다시 저장
                    queue.add(X);
                    for(int j = 0; j < i; j++){
                        //queue의 i번째에 X 보다 큰게 있는 것이므로 i까지만 반복
                        queue.add(queue.poll());
                    }
                    check = false; //X보다 큰 요소가 있다는 뜻으로 false;
                    break; // 걸러진 결과 반복문 종료
                }
            }

            if(check){
                number++;
                if(X[0] == M) break; //찾는 요소일 경우 반복문 종료
            }
        }
        return number;
    }
}
