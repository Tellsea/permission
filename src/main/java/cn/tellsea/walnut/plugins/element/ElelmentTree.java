package cn.tellsea.walnut.plugins.element;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * element tree
 *
 * @author: Tellsea
 * @date : 2019/12/16
 */
@Getter
@Setter
public class ElelmentTree {

    private int id;

    private String label;

    private String url;

    private List<ElelmentTree> children;
}
