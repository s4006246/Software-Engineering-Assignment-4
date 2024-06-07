import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PostTest {

    @Test
    public void testAddPost_TestCase1() {
        Post post = new Post();

        // Test Data 1
        assertFalse(post.addPost(1, "Testing", "Testing the functionality of a function", new String[]{"testing", "function"}));

        // Test Data 2
        assertFalse(post.addPost(2, "Race", "#Who wants to do a coding race competition", new String[]{"race", "code"}));
    }

    @Test
    public void testAddPost_TestCase2() {
        Post post = new Post();

        // Test Data 1
        assertFalse(post.addPost(3, "Computer Technology", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", new String[]{"computer"}));

        // Test Data 2
        assertFalse(post.addPost(4, "AI Machine Learning", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium.", new String[]{"AI", "Machine", "Learning", "PC", "Test", "Help"}));
    }

    @Test
    public void testAddPost_TestCase3() {
        Post post = new Post();

        // Test Data 1 (Invalid)
        assertFalse(post.addPost(5, "Computers Help", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium.", new String[]{"Computer", "Help"}));

        // Test Data 2
        assertFalse(post.addPost(6, "Computer Testing", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec.", new String[]{"Computer", "Help", "Test-1", "Tech"}));
    }



    @Test
    public void testAddPost_TestCase4() {
        Post post = new Post();

        // Test Data 1
        assertFalse(post.addPost(7, "Faulty Monitor", "My monitor isn't working", new String[]{"faulty", "monitor"}));

        // Test Data 2
        assertFalse(post.addPost(8, "Faulty Monitor", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget ", new String[]{"faulty", "monitor"}));
    }

    @Test
    public void testAddComment_TestCase5() {
        Post post = new Post();

        // Test Data 1
        assertFalse(post.addComment("Great idea"));

        // Test Data 2
        assertFalse(post.addComment("Cool"));
    }

    @Test
    public void testAddComment_TestCase6() {
        Post post = new Post();

        // Test Data 1
        assertFalse(post.addComment("i don’t know how to code"));

        // Test Data 2
        assertFalse(post.addComment("coding is fun but difficult"));
    }
}
