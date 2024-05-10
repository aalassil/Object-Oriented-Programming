import java.io.Serializable;

    /**
     * The Book class represents a book object that can be serialized.
     * This class implements the Serializable interface to allow for serialization and deserialization of Book objects.
     */
    public class Book implements Serializable {

        String title;
        String authors;
        double price;
        String isbn;
        String genre;
        int year;

        /**
         * WheeledTransportation default constructor that initialize its attributes to their null type.
         */
        public Book(){
            title = null;
            authors = null;
            price = 0;
            isbn = null;
            genre = null;
            year = 0;
        }

        /**
         * WheeledTransportation parameterized constructor that initializes its attributes.
         * @param title a String
         * @param authors a String
         * @param price a double
         * @param isbn a String
         * @param genre a String
         * @param year an Integer
         */
        public Book(String title, String authors, double price, String isbn, String genre, int year) {
            this.title = title;
            this.authors = authors;
            this.price = price;
            this.isbn = isbn;
            this.genre = genre;
            this.year = year;
        }

        /**
         * Sets the title of the book to the given title.
         * @param title title the new title of the book
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * Returns the title of the book.
         * @return the title of the book
         */
        public String getTitle() {
            return title;
        }


        /**
         * Sets the author to the given author.
         * @param authors new author of the book
         */
        public void setAuthors(String authors) {
            this.authors = authors;
        }

        /**
         * Returns the author of the book.
         * @return the author
         */
        public String getAuthors() {
            return authors;
        }

        /**
         * Sets the price of the book.
         * @param price new price
         */
        public void setPrice(double price) {
            this.price = price;
        }

        /**
         * Returns the price of the book.
         * @return the price
         */
        public double getPrice() {
            return price;
        }

        /**
         * Sets the ISBN of the book.
         * @param isbn new ISBN
         */
        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        /**
         * Returns the ISBN of the  book.
         * @return the ISBN
         */
        public String getIsbn() {
            return isbn;
        }

        /**
         * Sets the genre of the book.
         * @param genre new genre
         */
        public void setGenre(String genre) {
            this.genre = genre;
        }

        /**
         * Returns the genre of the book.
         * @return the genre
         */
        public String getGenre() {
            return genre;
        }

        /**
         * Sets the year of the book.
         * @param year new year
         */
        public void setYear(int year) {
            this.year = year;
        }

        /**
         * Returns the year of the book.
         * @return the year
         */
        public int getYear() {
            return year;
        }

        /**
         * Compares two object's attributes
         * @param obj takes an object
         * @return a boolean which would be true or false
         */
        @Override
        public boolean equals(Object obj) {
            if ( obj == null || this.getClass() != obj.getClass()){
                return false;
            }else{
                Book x = (Book) obj;
                return (x.title.equals(this.title)  && x.authors.equals(this.authors)
                        && x.price == this.price && x.isbn.equals(this.isbn)
                        && x.genre.equals(this.genre) && x.year == this.year);
            }
        }

        /**
         * displays the object's attributes.
         * @return a string that contains the attributes
         */
        @Override
        public String toString() {
            return "The Title is: " + title + "\n" +
                    "The Author/s is/are: " + authors + "\n" +
                    "The Price is: " + price + "\n" +
                    "The ISBN is: " + isbn + "\n" +
                    "The Genre is: " + genre + "\n" +
                    "The Year is: " + year + "\n";
        }
    }


