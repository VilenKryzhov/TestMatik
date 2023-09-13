package org.actions;

import org.objects.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksActions {
    List<Books> booksList = new ArrayList<>();
    String nameOfBook = null;

    public void createBooksList(List<String> titleList, List<String> authorList, List<String> priceList) {

        for (int i = 0; i < titleList.size(); i++) {
            booksList.add(new Books(titleList.get(i), authorList.get(i)
                    , priceList.get(i)));
        }
    }

    public String getNameOfBook(){
        for (Books book : booksList) {
            if (book.getTitle().equals("Head First Java, 2nd Edition")) {
                nameOfBook = book.getTitle();
            }
        }
        return nameOfBook;
    }

    public void getFilterAuthorList(List<String> list, List<String> filterList) {
        for (String s : list) {
            if (s.contains("by")) {
                int elementBy = s.indexOf("By");
                int elementBy2 = s.indexOf("|");
                String substring = s.substring(elementBy + 1, elementBy2 + 1);
                filterList.add(substring);
            }
        }
    }
}
