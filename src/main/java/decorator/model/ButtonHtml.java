package decorator.model;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ButtonHtml {

    @XmlValue
    private String button;
    @Builder.Default
    @XmlAttribute
    private String onclick = "window.location.href='%s';";

    //onclick="window.location.href = 'edit?id=6';"

}
