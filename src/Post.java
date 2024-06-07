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
        if (postTitle.length() < 10 || postTitle.length() > 250 || !postTitle.substring(0, 5).matches("[a-zA-Z]+")) {
            return false;
        }

        // Condition 2
        if (postBody.length() < 250) {
            return false;
        }

        // Condition 3
        if (postTags.length < 2 || postTags.length > 5) {
            return false;
        }
        for (String tag : postTags) {
            if (tag.length() < 2 || tag.length() > 10 || !tag.matches("[a-z]+")) {
                return false;
            }
        }

        // Condition 4
        if (postType.equals("Easy") && postTags.length > 3) {
            return false;
        } else if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postBody.length() < 300) {
            return false;
        }

        // Condition 5
        if (postType.equals("Easy") && (postEmergency.equals("Immediately Needed") || postEmergency.equals("Highly Needed"))) {
            return false;
        } else if ((postType.equals("Very Difficult") || postType.equals("Difficult")) && postEmergency.equals("Ordinary")) {
            return false;
        }

        // Add to text file if all conditions are true
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
        String[] words = comment.split("\\s+");
        if (words.length < 4 || words.length > 10 || !Character.isUpperCase(words[0].charAt(0))) {
            return false;
        }

        // Condition 2
        if ((postType.equals("Easy") || postEmergency.equals("Ordinary")) && postComments.size() >= 3) {
            return false;
        }
        if (postComments.size() >= 5) {
            return false;
        }

        // Add to text file if all conditions are true
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
