package eStoreSearch;

/*Swing Imports*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.util.ArrayList;


public class GUI extends JFrame{

    private static final long serialVersionUID = -4950320001959673277L;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public static ArrayList<Product> product = new ArrayList<Product>();

    /*
     *Main Panels
     */
    private String current;
    private JPanel firstJPanel;
    private JPanel commandJPanel; 
    private JPanel searchJPanel;
    private JPanel bookAdd;

    /*
     *Labels & Fields
     */
    private JTextField productJField;
    private JTextField descriptionJField;
    private JTextField priceJField;
    private JTextField yearJField;
    private JLabel authorsJLabel;
    private JTextField authorsJField;
    private JLabel publisherJLabel;
    private JTextField publisherJField;
    private JLabel makerJLabel;
    private JTextField makerJField;
    private JTextArea messages;

    /*
     *Smaller Search Panels
     */
    private JPanel searchField;
    private JPanel searchButtons;
    private JPanel searchResults;
    private JPanel searchingProducts;
    private JPanel searchingProductsButtons;
    private JPanel searchingProductsBox;

    private JTextField searchProductID;
    private JTextField searchDescription;
    private JTextField searchStart;
    private JTextField searchEnd;
    private JTextArea resultBox;

    /*
     * Buttons
     */
    private JButton addReset;
    private JButton add;
    private JButton searchReset;
    private JButton searchButton;

    /*
     * All action listener's
     */
    private class SearchListener implements ActionListener {

        public void actionPerformed(ActionEvent e){
            firstJPanel.setVisible(false);
            bookAdd.setVisible(false);
            searchJPanel.setVisible(true);
        }
    }

    private class AddBookListener implements ActionListener {

        public void actionPerformed(ActionEvent e){
            firstJPanel.setVisible(false);
            bookAdd.setVisible(true);
            searchJPanel.setVisible(false);
        }
    }

    /*
     * will quit the program when prompted
     */
    private class QuitListener implements ActionListener {

        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    private class AddSearchListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

        }

    }

    private class AddResetListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

        }
    }

    private class ResetSearchListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

        }
    }

    private class AddListener implements ActionListener {

        public void actionPerformed(ActionEvent e){
            
            boolean inValid=false;
        
            if (current.equals("book")){
                Book currentBook = new Book();
                double price = 0;

                currentBook.setProductID(productJField.getText());
                currentBook.setDescription(descriptionJField.getText());
                try {
                    price = Double.parseDouble(priceJField.getText());
                } catch (Exception b){
                    messages.setText("Invalid entry for price.");
                    inValid = true;
                }
                if (inValid == false){
                    currentBook.setPrice(price);
                }
            } else if (current.equals("electronics")){
                Electronics currentElectronic = new Electronics();

            }
        }
    }

    /*
     * will make maker field or author and publisher fields visible/not visible
     */
    private class TypeListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            String current2 = e.getActionCommand();

            if (current2.equals("electronics")){
                current="electronics";
                makerJLabel.setVisible(true);
                makerJField.setVisible(true);
                authorsJLabel.setVisible(false);
                authorsJField.setVisible(false);
                publisherJLabel.setVisible(false);
                publisherJField.setVisible(false);

            } else if (current2.equals("book")){
                current="book"; 
                authorsJLabel.setVisible(true);
                authorsJField.setVisible(true);
                publisherJLabel.setVisible(true);
                publisherJField.setVisible(true);
                makerJLabel.setVisible(false);
                makerJField.setVisible(false);
            }
        }
    }

    /*
     * Where GUI will be set up
     */
    public GUI(){
        super();

        setSize(WIDTH, HEIGHT);
        setTitle("eStoreSearch");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * setting layout 
         */
        setLayout(new BorderLayout());

        commandJPanel = new JPanel();
        commandJPanel.setSize(400, 50);
        commandJPanel.setLayout(new FlowLayout());

        /*
         * command buttons
         */
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new AddBookListener());
        commandJPanel.add(addButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new QuitListener());
        commandJPanel.add(quitButton);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchListener());
        commandJPanel.add(searchButton);

        add(commandJPanel, BorderLayout.NORTH);
        commandJPanel.setVisible(true);

        /*
         * opening section for the GUI
         */
        firstJPanel = new JPanel();
        firstJPanel.setLayout(new BorderLayout());
        JLabel welcome = new JLabel("Welcome to eStoreSearch");
        firstJPanel.add(welcome, BorderLayout.CENTER);
        JLabel welcomeDescription = new JLabel("Choose a command from the 'Commands' menu above for adding a product, searching products, or quitting the program.");
        firstJPanel.add(welcomeDescription, BorderLayout.SOUTH);
        add(firstJPanel);

        /*
         * making visible at begining of the program
         */
        firstJPanel.setVisible(true);

        /*
         * adding the book and electronic window
         */
        bookAdd = new JPanel();
        bookAdd.setSize(400, 250);
        bookAdd.setLayout(new FlowLayout());
        JLabel space = new JLabel("");

        searchField = new JPanel();
        searchField.setSize(250, 150);
        searchField.setLayout(new GridLayout(9,2));//for search fields
        JLabel addingProduct = new JLabel("Adding a product");
        searchField.add(addingProduct);
        searchField.add(space);

        JLabel typeLabel = new JLabel("Type: ");
        searchField.add(typeLabel);

        String[] type = {"book", "electronics"};
        JComboBox<String> types = new JComboBox<String>(type);
        types.setSelectedIndex(0);
        types.addActionListener(new TypeListener());
        searchField.add(types);

        JLabel productLabel = new JLabel("ProductID:");
        searchField.add(productLabel);
        productJField = new JTextField();
        searchField.add(productJField);

        JLabel descriptionLabel = new JLabel("Description:");
        searchField.add(descriptionLabel);
        descriptionJField = new JTextField();
        searchField.add(descriptionJField);

        JLabel priceLabel = new JLabel("Price:");
        searchField.add(priceLabel);
        priceJField = new JTextField();
        searchField.add(priceJField);

        JLabel yearLabel = new JLabel("Year:");
        searchField.add(yearLabel);
        yearJField = new JTextField();
        searchField.add(yearJField);

        makerJLabel = new JLabel("Maker:");
        searchField.add(makerJLabel);
        makerJLabel.setVisible(false);
        makerJField = new JTextField();
        searchField.add(makerJField);
        makerJField.setVisible(false);

        authorsJLabel = new JLabel("Authors:");
        searchField.add(authorsJLabel);
        authorsJField = new JTextField();
        searchField.add(authorsJField);

        publisherJLabel = new JLabel("Publisher:");
        searchField.add(publisherJLabel);
        publisherJField = new JTextField();
        searchField.add(publisherJField);

        bookAdd.add(searchField); //adding it to add board

        /*
         * add and reset buttons
         */
        searchButtons = new JPanel();
        searchButtons.setSize(150, 150);
        searchButtons.setLayout(new GridLayout(2,1)); //layout for the buttons

        add = new JButton("Add");
        add.addActionListener(new AddListener());
        searchButtons.add(add);

        addReset = new JButton("Reset");
        addReset.addActionListener(new AddResetListener());
        searchButtons.add(addReset);

        bookAdd.add(searchButtons); //adding buttons to the GUI

        /*
         * Message box display
         */
        searchResults = new JPanel();
        searchResults.setSize(400,100);
        searchResults.setLayout(new GridLayout(2,1)); //for Message box and label

        JLabel messageBox = new JLabel("Messages");
        searchResults.add(messageBox);
        messages = new JTextArea(5, 40);
        searchResults.add(messages);
        bookAdd.add(searchResults); 

        bookAdd.setVisible(false); //hide this initially
        add(bookAdd);

         /*
         * Search Panel
         */
        searchJPanel = new JPanel();
        searchJPanel.setSize(425, 275);
        searchJPanel.setLayout(new FlowLayout());

        /*
         *dealing with all attributes
         */
        searchingProducts = new JPanel();
        searchingProducts.setSize(350,200);
        searchingProducts.setLayout(new GridLayout(5,2));
        JLabel searchTitle = new JLabel("Searching Products");
        searchingProducts.add(searchTitle);
        searchingProducts.add(space); //skipping a grid space

        JLabel searchProductIDLabel = new JLabel("ProductID:");
        searchingProducts.add(searchProductIDLabel);
        searchProductID = new JTextField();
        searchingProducts.add(searchProductID);

        JLabel searchDescriptionLabel = new JLabel("Description Keywords:");
        searchingProducts.add(searchDescriptionLabel);
        searchDescription = new JTextField();
        searchingProducts.add(searchDescription);

        JLabel searchStartLabel = new JLabel("Start Year:");
        searchingProducts.add(searchStartLabel);
        searchStart = new JTextField();
        searchingProducts.add(searchStart);

        JLabel searchEndLabel = new JLabel("End Year:");
        searchingProducts.add(searchEndLabel);
        searchEnd = new JTextField();
        searchingProducts.add(searchEnd);

        searchPanel.add(searchingProducts); //adding to the search GUI

        /*
         * Search and reset buttons 
         */
        searchingProductsButtons = new JPanel();
        searchingProductsButtons.setSize(150,150);
        searchingProductsButtons.setLayout(new GridLayout(2,1));

        searchButton = new JButton("Search");
        searchButton.addActionListener(new AddSearchListener());
        searchingProductsButtons.add(searchButton);

        searchReset = new JButton("Reset");
        searchReset.addActionListener(new ResetSearchListener());
        searchingProductsButtons.add(searchReset);

        searchPanel.add(searchingProductsButtons); //adding to search GUI

        /*
         * Search results Box
         */
        searchingProductsBox = new JPanel();
        searchingProductsBox.setSize(400,100);
        searchingProductsBox.setLayout(new GridLayout(2,1)); //for Message box
        JLabel results = new JLabel("Search Results");
        searching.add(results);
        resultBox = new JTextArea(5, 40);
        searchingProductsBox.add(resultBox);

        searchPanel.add(searchingProductsBox); //adding messages to the gui
        searchPanel.setVisible(false);
        add(searchPanel);
    }

}