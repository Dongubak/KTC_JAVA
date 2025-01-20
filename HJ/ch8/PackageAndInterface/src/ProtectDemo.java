class ProtectDemo {
    public static void main(String args[]) {
        bookpack.bookpackext.ExtBook books[] = new bookpack.bookpackext.ExtBook[5];

        books[0] = new bookpack.bookpackext.ExtBook("Java: A Beginner's Guide", "Schildt", 2014, "McGraw-Hill");
        books[1] = new bookpack.bookpackext.ExtBook("Java: The Complete Reference", "Schildt", 2014, "McGraw-Hill");
        books[2] = new bookpack.bookpackext.ExtBook("The Art of Java", "Schildt and Holmes", 2003, "McGraw-Hill");
        books[3] = new bookpack.bookpackext.ExtBook("Red Storm Rising", "Clancy", 1986, "Putnam");
        books[4] = new bookpack.bookpackext.ExtBook("On the Road", "Kerouac", 1955, "Viking");

        for (int i = 0; i < books.length; i++) books[i].show();

        // 특정 작가의 책 찾기
        System.out.println("Showing all books by Schildt.");
        for (int i = 0; i < books.length; i++)
            if (books[i].getAuthor().equals("Schildt"))
                System.out.println(books[i].getTitle());

        // books[0].title = "New Title";  // 오류 발생 - ProtectDemo는 하위 클래스가 아님
    }
}