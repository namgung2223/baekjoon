package data_structure;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {

    static int N;
    static int[] arrn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arrn = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arrn[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrn);

        int X = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < X; i++){
            //해당 비교 배열 요소들을 저장하지 않아도 됨 우리에게 필요한 것은 1과 0으로 된 문자열이니까.
            int num = Integer.parseInt(st.nextToken());

            bw.write(BinarySeach(num) + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int BinarySeach(int num){ //이진/이분 탐색 => 요소를 하나씩 넣어서 비교한다.
        int left = 0; //인덱스 : 배열의 요소는 0부터 시작
        int right = N-1; //인덱스 : 배열의 요소는 0부터 시작하므로 N-1을 해준다.

        while(left <= right){ //left가 rigth보다 큰 경우는 이진 탐색 규칙에 어긋나므로 반복문 돌리지 X
            int middle = (left + right)/2; //중간 인덱스는 왼쪽 오른쪽의 더한 값에 나누기 2
            int middleValue = arrn[middle]; //중간 인덱스에 해당되는 값 => 이 값으로 비교한다.

            if(num > middleValue){ //만약 num이 중간값보다 크면
                left = middle +1;
            }else if(num < middleValue){ //만약 num이 중간값보다 작으면
                right = middle -1;
            }else return 1; //찾았을 경우 (middleValue == num)일 경우
        }
        return 0; //상근이의 카드에 num이 없을 경우
    }
}
