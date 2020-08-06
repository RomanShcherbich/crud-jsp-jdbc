package decorator.model;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "p",
        "button"
})
@XmlRootElement(name = "td")
public class TdHtml {

    private String p;
    private List<ButtonHtml> button;

    public TdHtml(String p) {
        this.p = p;
    }

    public TdHtml(List<ButtonHtml> button) {
        this.button = button;
    }
}
