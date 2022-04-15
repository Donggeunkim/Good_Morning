package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class File_IO_test {
    File_IO file_io;

    @BeforeEach
    void SetUp() {
        file_io = mock(File_IO.class);
    }

    @Test
    void checkFileName_test() {
        assertEquals(false, file_io.checkFileName("input.txy"));
        assertEquals(true, file_io.checkFileName("input.txt"));
    }

    @Test
    void readInputFile_test(){
        String filePath = null;
        assertThrows(NullPointerException.class, () -> file_io.readInputFile(filePath));

        String filePath2 = "NoneFile.txt";
        assertThrows(IOException.class, () -> file_io.readInputFile(filePath2));
    }

    @Test
    void writePrint2File(){
        String filePath = null;
        ArrayList<String> printList = new ArrayList<String>(
                Arrays.asList("ADD, , , ,04766290,BAE UDQJNXD,CL1,010-7899-1662,19770102,ADV",
                              "ADD, , , ,14387681,CHOI HMDEJXV,CL3,010-0424-2511,19870508,ADV",
                              "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO"));

        assertThrows(NullPointerException.class, () -> file_io.writePrint2File(filePath, printList));

//        String filePath2 = "writeTest.txt";
//        assertThrows(IOException.class, () -> file_io.writePrint2File(filePath2, printList));
    }
}
