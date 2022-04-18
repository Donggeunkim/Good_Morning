package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class FileIoTest {
    FileIo fileIo;

    @BeforeEach
    void setUp() {
        fileIo = mock(FileIo.class);
    }

    @Test
    void checkFileNameTest() {
        assertEquals(false, fileIo.checkFileName("input.txy"));
        assertEquals(true, fileIo.checkFileName("input.txt"));
    }

    @Test
    void radInputFileTest(){
        String filePath = null;
        assertThrows(NullPointerException.class, () -> FileIo.readInputFile(filePath));

        String filePath2 = "NoneFile.txt";
        assertThrows(IOException.class, () -> FileIo.readInputFile(filePath2));
    }

    @Test
    void writePrint2FileTest(){
        String filePath = null;
        ArrayList<String> printList = new ArrayList<String>(
                Arrays.asList("ADD, , , ,04766290,BAE UDQJNXD,CL1,010-7899-1662,19770102,ADV",
                              "ADD, , , ,14387681,CHOI HMDEJXV,CL3,010-0424-2511,19870508,ADV",
                              "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO"));

        assertThrows(NullPointerException.class, () -> FileIo.writePrint2File(filePath, printList));
    }
}
