package project;

import java.util.*;

abstract class User {
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String gender;

    public User(int id, String name, String email, String username, String password, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public abstract void displayDetails();
}

class JobSeeker extends User {
    private Date lastUpdated;

    public JobSeeker(int id, String name, String email, String username, String password, String gender) {
        super(id, name, email, username, password, gender);
        this.lastUpdated = new Date();
    }

    public void updateTimestamp() {
        this.lastUpdated = new Date();
    }

    @Override
    public void displayDetails() {
        System.out.println("JobSeeker Profile:");
        System.out.println("ID       : " + getId());
        System.out.println("Name     : " + getName());
        System.out.println("Username : " + getUsername());
        System.out.println("Email    : " + getEmail());
        System.out.println("Gender   : " + getGender());
        System.out.println("Last Updated : " + lastUpdated);
        System.out.println("Profile Completeness : " + calculateProfileCompleteness() + "%");
        System.out.println("-------------------------");
    }

    public int calculateProfileCompleteness() {
        int count = 0;
        if (getId() != 0) count++;
        if (getName() != null && !getName().isEmpty()) count++;
        if (getEmail() != null && !getEmail().isEmpty()) count++;
        if (getUsername() != null && !getUsername().isEmpty()) count++;
        if (getPassword() != null && !getPassword().isEmpty()) count++;
        if (getGender() != null && !getGender().isEmpty()) count++;
        return (count * 100) / 6;
    }
}

interface PortalService {
    void create();
    void read();
    void update();
    void delete();
    void search();
}

class JobSeekerManager implements PortalService {
    List<JobSeeker> seekers = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    private boolean isUsernameTaken(String username) {
        return seekers.stream().anyMatch(s -> s.getUsername().equalsIgnoreCase(username));
    }

    private boolean isValidEmail(String email) {
        return email.toLowerCase().endsWith("@gmail.com");
    }

    private boolean isValidUsername(String username) {
        return username.length() >= 8 && username.matches(".*[A-Z].*") && username.matches(".*[a-z].*");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    @Override
    public void create() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        String email;
        while (true) {
            System.out.print("Enter Email: ");
            email = sc.nextLine();
            if (isValidEmail(email)) break;
            System.out.println("Email must end with @gmail.com");
        }

        String username;
        while (true) {
            System.out.print("Enter Username: ");
            username = sc.nextLine();
            if (isUsernameTaken(username)) {
                System.out.println("Username already exists. Try another one.");
            } else if (!isValidUsername(username)) {
                System.out.println("Username must be 8+ characters with upper & lower case letters.");
            } else break;
        }

        String password;
        while (true) {
            System.out.print("Enter Password: ");
            password = sc.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Password must be at least 8 characters.");
            } else break;
        }

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        JobSeeker js = new JobSeeker(id, name, email, username, password, gender);
        seekers.add(js);
        System.out.println("JobSeeker created successfully!\n");
    }

    @Override
    public void read() {
        if (seekers.isEmpty()) {
            System.out.println("No JobSeekers found.\n");
            return;
        }
        for (JobSeeker js : seekers) {
            js.displayDetails();
        }
        System.out.println("Total JobSeekers: " + seekers.size() + "\n");
    }

    @Override
    public void update() {
        System.out.print("Enter username to update: ");
        String uname = sc.nextLine();

        JobSeeker js = findByUsername(uname);
        if (js == null) {
            System.out.println("Username not found.\n");
            return;
        }

        System.out.print("Enter new Name: ");
        js.setName(sc.nextLine());

        String email;
        while (true) {
            System.out.print("Enter new Email: ");
            email = sc.nextLine();
            if (isValidEmail(email)) break;
            System.out.println("Email must end with @gmail.com");
        }
        js.setEmail(email);

        String password;
        while (true) {
            System.out.print("Enter new Password: ");
            password = sc.nextLine();
            if (isValidPassword(password)) break;
            System.out.println("Password must be at least 8 characters.");
        }
        js.setPassword(password);

        System.out.print("Enter new Gender: ");
        js.setGender(sc.nextLine());

        js.updateTimestamp();
        System.out.println("JobSeeker updated successfully!\n");
    }

    @Override
    public void delete() {
        if (seekers.isEmpty()) {
            System.out.println("No JobSeekers to delete.\n");
            return;
        }

        System.out.println("Available usernames:");
        for (JobSeeker js : seekers) {
            System.out.println(" - " + js.getUsername());
        }

        System.out.print("Enter username to delete: ");
        String uname = sc.nextLine();

        JobSeeker js = findByUsername(uname);
        if (js == null) {
            System.out.println("Username not found.\n");
            return;
        }

        seekers.remove(js);
        System.out.println("JobSeeker deleted successfully!\n");
    }

    @Override
    public void search() {
        System.out.print("Enter username to search: ");
        String uname = sc.nextLine();

        JobSeeker js = findByUsername(uname);
        if (js == null) {
            System.out.println("No JobSeeker found.\n");
        } else {
            js.displayDetails();
        }
    }

    private JobSeeker findByUsername(String uname) {
        for (JobSeeker js : seekers) {
            if (js.getUsername().equalsIgnoreCase(uname)) return js;
        }
        return null;
    }
}

public class JobPortalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JobSeekerManager manager = new JobSeekerManager();

        while (true) {
            System.out.println("=== Job Portal System ===");
            System.out.println("1. Create JobSeeker");
            System.out.println("2. Read JobSeekers");
            System.out.println("3. Update JobSeeker");
            System.out.println("4. Delete JobSeeker");
            System.out.println("5. Exit");
            System.out.println("6. Search JobSeeker by Username");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1: manager.create(); break;
                    case 2: manager.read(); break;
                    case 3: manager.update(); break;
                    case 4: manager.delete(); break;
                    case 5:
                        System.out.println("Exiting Job Portal System. Thank you!");
                        return;
                    case 6: manager.search(); break;
                    default: System.out.println("Invalid choice. Please select 1–6.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1–6).\n");
            }
        }
    }
}

