package decorator;

import javax.xml.bind.*;
import java.io.StringWriter;

public class JaxbUtils {

    public static String convertXmlObjectToString(Object xml) {
        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();
        try {
        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(xml.getClass());
        Marshaller marshaller = null;
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            // сама сериализация
            marshaller.marshal(xml, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        //преобразовываем в строку все записанное в StringWriter
        return writer.toString();
    }

}
