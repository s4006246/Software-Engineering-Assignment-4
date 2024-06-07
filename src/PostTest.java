import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PostTest {

    @Test
    public void testAddPost_TestCase1() {
        Post post = new Post();

        // Test Data 1
        assertFalse(post.addPost(1, "Testing", "Testing the functionality of a function", new String[]{"testing", "function"}, "Easy", "Ordinary"));

        // Test Data 2
        assertFalse(post.addPost(2, "#Race", "Who wants to do a coding race competition", new String[]{"race", "code"}, "Difficult", "Highly Needed"));
    }

    @Test
    public void testAddPost_TestCase2() {
        Post post = new Post();

        // Test Data 1
        assertFalse(post.addPost(3, "Computer Technology", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", new String[]{"computer"}, "Very Difficult", "Highly Needed"));

        // Test Data 2
        assertFalse(post.addPost(4, "AI Machine Learning", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium.", new String[]{"ai", "machine", "learning", "pc", "test", "help"}, "Easy", "Ordinary"));
    }

    @Test
    public void testAddPost_TestCase3() {
        Post post = new Post();

        // Test Data 1 (Invalid)
        assertFalse(post.addPost(5, "Computers Help", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium.", new String[]{"computer", "help", "easy", "sad"}, "Easy", "Ordinary"));

        // Test Data 2
        assertFalse(post.addPost(6, "Computer Testing", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", new String[]{"Computer", "Help", "Test", "Tech"}, "Difficult", "Highly Needed"));
    }



    @Test
    public void testAddPost_TestCase4() {
        Post post = new Post();

        // Test Data 1
        assertTrue(post.addPost(7, "Faulty Monitor", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium.", new String[]{"faulty", "monitor"}, "Easy", "Ordinary"));

        // Test Data 2
        assertFalse(post.addPost(8, "Faulty Monitor", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget ", new String[]{"faulty", "monitor"}, "Difficult", "Ordinary"));
    }

    @Test
    public void testAddComment_TestCase5() {
        Post post = new Post();

        // Test Data 1
        post.addPost(9, "I have an idea", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", new String[]{"idea", "smart"}, "Easy", "Ordinary");

        assertTrue(post.addComment("Great idea lets go out!"));

        // Test Data 2
        assertFalse(post.addComment("Cool"));
    }

    @Test
    public void testAddComment_TestCase6() {
        Post post = new Post();

        // Test Data 1
        assertFalse(post.addComment("i don’t know how to code"));

        // Test Data 2
        assertFalse(post.addComment("coding is Fun but difficult"));
    }
}
