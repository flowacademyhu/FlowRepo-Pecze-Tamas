public class Help {
        protected boolean fiftyfifty;
        protected boolean telephone;
        protected boolean viewers;
        public String FiftyFifty(String s) {
            return s;
        }
         public String Telephone(String s) {
        return s;
         }
         public String Viewers(String s) {
        return s;
           }


    public Help() {
            this.fiftyfifty = true;
            this.telephone = true;
            this.viewers = true;
    }

    public boolean isFiftyfifty() {
        return fiftyfifty;
    }

    public void setFiftyfifty(boolean fiftyfifty) {
        this.fiftyfifty = fiftyfifty;
    }

    public boolean isTelephone() {
        return telephone;
    }

    public void setTelephone(boolean telephone) {
        this.telephone = telephone;
    }

    public boolean isViewers() {
        return viewers;
    }

    public void setViewers(boolean viewers) {
        this.viewers = viewers;
    }
}