package org.study.quotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Command cmd = new Command();

        System.out.println("== 명언 앱 ==");
        cmd.progressLoad();

        boolean flag = true;
        while (flag) {
            System.out.print("명령)");
            String command = br.readLine();

            switch (command) {
                case "등록":
                    System.out.print("명언 : ");
                    String phrase = br.readLine();

                    System.out.print("작가 : ");
                    String author = br.readLine();

                    cmd.save(phrase, author);
                    break;
                case "목록":
                    cmd.show();
                    break;
                case "종료":
                    System.out.println("종료 전에 저장을 원하신다면 1, 원하지 않으신다면 2를 입력해주세요.");
                    String chk = br.readLine();
                    if(chk.equals("1")){
                        cmd.progressSave();
                        System.out.println("프로그램이 종료됩니다.");
                    }else if(chk.equals("2")){
                        System.out.println("프로그램이 종료됩니다.");
                    } else{
                        System.out.println("잘못된 값입니다. 자동저장 됩니다.");
                        cmd.progressSave();
                    }
                    flag = false;
                    break;
                case "저장":
                    cmd.progressSave();
                    break;
                case "불러오기":
                    cmd.progressLoad();
                    break;
                case "초기화":
                    cmd.clear();
                    break;
                case "명령어":
                    System.out.println("\t등록 - 명언을 등록할 수 있습니다.");
                    System.out.println("\t목록 - 등록한 명언의 목록을 확인 할 수 있습니다.");
                    System.out.println("\t삭제 - 삭제?id=[] 와 같은 형식으로 사용할 수 있으며, [] 안에 id 값을 입력하시면 됩니다.");
                    System.out.println("\t저장 - 현재 상태를 저장할 수 있습니다.");
                    System.out.println("\t불러오기 - 마지막 저장한 내용을 불러올 수 있습니다.");
                    System.out.println("\t초기화 - 명언집을 초기화 할 수 있습니다.");
                    System.out.println("\t종료 - 프로그램을 종료할 수 있습니다. / 종료 시 등록한 명언 자동 저장 됩니다.");
                    break;
                default:
                    if (command.matches("삭제\\?id\\=[0-9]+")) {
                        System.out.println(cmd.remove(Long.valueOf(command.split("=")[1])));
                    } else {
                        System.out.println("잘못된 명령어 입니다.");
                    }
            }
        }
    }
}