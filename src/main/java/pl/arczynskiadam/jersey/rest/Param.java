package pl.arczynskiadam.jersey.rest;

import javax.validation.constraints.Size;

public class Param {

    @Size(min = 2, max = 4, message = "QueryParam must be between 2 and 4 characters")
    String val;

    public Param(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
