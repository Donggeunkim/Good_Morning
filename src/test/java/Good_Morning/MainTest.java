package Good_Morning;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    void mainTest() throws IOException {
        String[] inputArgs = {"input.txt","output.txt"};
        Main.main(inputArgs);
        File file_out = new File("output.txt");
        File file_sol = new File("output_sol.txt");
        assertTrue(FileUtils.contentEqualsIgnoreEOL(file_sol, file_out, null));
    }
}
