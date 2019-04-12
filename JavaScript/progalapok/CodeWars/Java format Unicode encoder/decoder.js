class JavaUnicodeEncoder{
  static decode(input){
    let stringy = '';
    for (let i = 0; i < input.length; i++) {
    stringy += String.charCodeAt(input[i]);
    return stringy;
  }
}
  
  
   encode(input){
    let stringy = '';
    for (let i = 0; i < input.length; i++) {
    stringy += String.fromCharCode(input[i]);
    return stringy;
  }
  
}