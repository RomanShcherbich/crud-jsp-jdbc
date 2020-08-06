package decorator.html;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlType(name = "", propOrder = {
        "td"
})
@XmlRootElement(name = "tr")
public class UsersRowHtml {

    private List<TdHtml> td;

}
