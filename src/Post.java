import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String postType;
    private String postEmergency;
    private ArrayList<String> postComments = new ArrayList<>();

    private static final String[] postTypes = {"Very Difficult", "Difficult", "Easy"};
    private static final String[] postEmergencies = {"Immediately Needed", "Highly Needed", "Ordinary"};

    // addPost Function
    public boolean addPost(int postID, String postTitle, String postBody, String[] postTags, String postType, String postEmergency) {
        this.postID = postID;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postTags = postTags;
        this.postType = postType;
        this.postEmergency = postEmergency;

        // Condition 1
        // Minimum 10 char, maximum 250 char & shouldn't have any number or special character in the first 5 char
        if (postTitle.length() < 10 || postTitle.length() > 250 || !postTitle.substring(0, 5).matches("[a-zA-Z]+")) {
            return false;
        }

        // Condition 2
        // Minimum of 250 char
        if (postBody.length() < 250) {
            return false;
        }

        // Condition 3
        // Minimum 2 tags, maximum 5 tags, minimum 2 char, maximum 10 char & no uppercase letters
        if (postTags.length < 2 || postTags.length > 5) {
            return false;
        }
        for (String tag : postTags) {
            if (tag.length() < 2 || tag.length() > 10 || !tag.matches("[a-z]+")) {
                return false;
            }
        }

        // Condition 4
        // Post Types, If type Easy, no more than 3 tags & if type Very Difficult or Difficult, it should have minimum 300 char in the body
        if (postType.equals("Easy") && postTags.length > 3) {
            return false;
        } else if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postBody.length() < 300) {
            return false;
        }

        // Condition 5
        // Emergency of an answer, Easy shouldn't have the Immediately Needed or Highly Needed statuses & Very Difficult or Difficult posts 
        //      should not have Ordinary status
        if (postType.equals("Easy") && (postEmergency.equals("Immediately Needed") || postEmergency.equals("Highly Needed"))) {
            return false;
        } else if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postEmergency.equals("Ordinary")) {
            return false;
        }

        // Adds to post text file if all conditions are true
        try (FileWriter writer = new FileWriter("post.txt", true)) {
            writer.write("Post ID: " + postID + "\n");
            writer.write("Title: " + postTitle + "\n");
            writer.write("Body: " + postBody + "\n");
            writer.write("Tags: ");
            for (String tag : postTags) {
                writer.write(tag + " ");
            }
            writer.write("\n");
            writer.write("Type: " + postType + "\n");
            writer.write("Emergency: " + postEmergency + "\n");
            writer.write("Comments: " + postComments + "\n");
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // addComment Function
    public boolean addComment(String comment) {
        // Condition 1
        // Minimum 4 words, maximum 10 words & first char must have uppercase letter
        String[] words = comment.split("\\s+");
        if (words.length < 4 || words.length > 10 || !Character.isUpperCase(words[0].charAt(0))) {
            return false;
        }

        // Condition 2
        // Each post can have 0 - 5 comments, but posts that are Easy or Ordinary should have maximum 3 comments
        if ((postType.equals("Easy") || postEmergency.equals("Ordinary")) && postComments.size() >= 3) {
            return false;
        }
        if (postComments.size() >= 5) {
            return false;
        }

        // Add to comment text file if all conditions are true
        postComments.add(comment);
        try (FileWriter writer = new FileWriter("comment.txt", true)) {
            writer.write("Post ID: " + postID + "\n");
            writer.write("Comment: " + comment + "\n");
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
