package Pogrammieren.Klausurvorbereitung.Probeklausur.Datenstrukturen;

public class WordsIWantToLearn{
    Element peekElement = null;
    public void push(String data){
        peekElement = new Element(data, peekElement);
    }
    public String pop(){
        String result = peekElement.getData();
        peekElement = peekElement.getPrevElement();
        return result;
    }
    public String peek(){
        return peekElement.getData();
    }

    private class Element{
        private String data;
        private Element prevElement;
        public Element(String data, Element prevElement) {
            this.data = data;
            this.prevElement = prevElement;
        }
        public String getData(){
            return data;
        }
        public Element getPrevElement(){
            return prevElement;
        }
    }
}