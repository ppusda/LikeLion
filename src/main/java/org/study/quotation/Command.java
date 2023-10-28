package org.study.quotation;

import java.util.ArrayList;

public class Command {

    private String message;
    private ArrayList<Quotation> quotationList = new ArrayList<>();
    FileUtil fileUtil = new FileUtil();

    String parse(String cmd) {
        if(cmd.contains("?")) {
            return message;
        }

        return cmd;
    }

    void save(String phrase, String author) {
        Long id = getLastId()+1;
        quotationList.add(new Quotation(id, phrase, author));
        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    void show() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------");

        for (Quotation quotation : quotationList) {
            System.out.println(
                    quotation.getId() + " / " + quotation.getAuthor() + " / " + quotation.getPhrase());
        }
    }

    boolean phraseCheck(Long id) {
        return quotationList.stream().anyMatch(quotation -> quotation.getId() == id.intValue());
    }

    Quotation getPhrase(Long id) {
        return quotationList.stream().parallel().filter(p -> p.getId() == id.intValue()).findAny()
                .orElseThrow(IllegalAccessError::new);
    }

    Long getLastId() {
        if(!quotationList.isEmpty()){
            return quotationList.get(quotationList.size()-1).getId();
        }else {
            return 0L;
        }
    }

    String remove(Long id) {
        if (phraseCheck(id)) {
            quotationList.remove(getPhrase(id));
            return id + "번 명언이 삭제되었습니다.";
        } else {
            return id + "번 명언은 존재하지 않습니다.";
        }
    }

    void progressSave() {
        fileUtil.fileSave(quotationList);
    }

    void progressLoad() {
        quotationList = fileUtil.fileLoad();
    }

    void clear() {
        quotationList.clear();
    }

}
