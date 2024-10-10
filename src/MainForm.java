import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private final Stack<Person> people;
    private JPanel mainPanel;
    private JTextField nameInput;
    private JTextField ageInput;
    private JButton addPersonButton;
    private JButton searchButton;
    private JTextField searchInput;
    private JLabel stackCountLabel;
    private JButton popButton;
    private JButton peekButton;

    MainForm(Stack<Person> stack) {
        super("Stacking people");

        people = stack;

        addPersonButton.addActionListener(e -> onAddPerson());
        searchButton.addActionListener(e -> onSearch());
        popButton.addActionListener(e -> onPop());
        peekButton.addActionListener(e -> onPeek());

        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - getWidth() / 2, (Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - getHeight() / 2);
    }

    private void onPeek() {
        Person person = people.peek();

        if (person == null) {
            return;
        }

        SearchResultDialog searchResultDialog = new SearchResultDialog(person);
        searchResultDialog.pack();
        searchResultDialog.setVisible(true);
    }

    private void onPop() {
        Person person = people.pop();

        if (person == null) {
            return;
        }

        SearchResultDialog searchResultDialog = new SearchResultDialog(person);
        searchResultDialog.pack();
        searchResultDialog.setVisible(true);

        updateStackCountLabel();
    }

    private void onSearch() {
        String query = searchInput.getText();

        if (query.isEmpty()) {
            return;
        }

        StackSearchInterface<Person> search = (Person person) -> person.name.contains(query);

        if (people.contains(search)) {
            Person person = people.fetch(search);

            SearchResultDialog searchResultDialog = new SearchResultDialog(person);
            searchResultDialog.pack();
            searchResultDialog.setVisible(true);
        }
    }

    private void onAddPerson() {
        String name = nameInput.getText();

        if (name.isEmpty()) {
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageInput.getText());
        } catch (NumberFormatException e) {
            return;
        }

        people.push(new Person(name, age));

        nameInput.setText("");
        ageInput.setText("");

        updateStackCountLabel();
    }

    private void updateStackCountLabel() {
        stackCountLabel.setText(Integer.toString(people.length()));
    }
}
