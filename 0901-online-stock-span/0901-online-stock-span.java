class StockSpanner {
    Stack<SharePrice> priceStack;
    int day=0;
    
    public StockSpanner() {
      priceStack=new Stack<>();
    }
    
    public int next(int price) {
        day++;
       SharePrice sp=new SharePrice(day,price);
        
        while(!priceStack.isEmpty() && priceStack.peek().getPrice()<=price){
            priceStack.pop();
        }
        if(priceStack.isEmpty()){
            priceStack.push(sp);
            return day;
        }
        int res=priceStack.peek().getDay();
        priceStack.push(sp);
        return day-res;
    }
}

class SharePrice{
    int day;
    int price;
    
    SharePrice(int day,int price){
        this.day=day;
        this.price=price;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getPrice(){
        return price;
    }
}
