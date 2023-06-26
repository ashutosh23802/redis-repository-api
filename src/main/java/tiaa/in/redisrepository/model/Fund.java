package tiaa.in.redisrepository.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Fund")
public class Fund  implements Serializable {

    private String cusip;
    private int reportingSeq;
    private int categoryFundSeq;
    private String externalTickerSymbol;
    private String name;
    private String tickerSymbol;

    public Fund() {
    }

    private Fund(Builder builder) {
        setCusip(builder.cusip);
        setReportingSeq(builder.reportingSeq);
        setCategoryFundSeq(builder.CategoryFundSeq);
        setExternalTickerSymbol(builder.externalTickerSymbol);
        setName(builder.name);
        setTickerSymbol(builder.tickerSymbol);
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public int getReportingSeq() {
        return reportingSeq;
    }

    public void setReportingSeq(int reportingSeq) {
        this.reportingSeq = reportingSeq;
    }

    public int getCategoryFundSeq() {
        return categoryFundSeq;
    }

    public void setCategoryFundSeq(int categoryFundSeq) {
        this.categoryFundSeq = categoryFundSeq;
    }

    public String getExternalTickerSymbol() {
        return externalTickerSymbol;
    }

    public void setExternalTickerSymbol(String externalTickerSymbol) {
        this.externalTickerSymbol = externalTickerSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }


    public static final class Builder {
        private String cusip;
        private int reportingSeq;
        private int CategoryFundSeq;
        private String externalTickerSymbol;
        private String name;
        private String tickerSymbol;

        public Builder() {
        }

        public Builder withCusip(String val) {
            cusip = val;
            return this;
        }

        public Builder withReportingSeq(int val) {
            reportingSeq = val;
            return this;
        }

        public Builder withCategoryFundSeq(int val) {
            CategoryFundSeq = val;
            return this;
        }

        public Builder withExternalTickerSymbol(String val) {
            externalTickerSymbol = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withTickerSymbol(String val) {
            tickerSymbol = val;
            return this;
        }

        public Fund build() {
            return new Fund(this);
        }
    }
}
