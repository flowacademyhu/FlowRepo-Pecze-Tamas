import { Directive, Renderer2, ElementRef, HostListener} from '@angular/core';

@Directive({
  selector: '[appTask6]'
})
export class Task6Directive {

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {
    this.renderer.setStyle(this.elementRef.nativeElement, 'background-color' , 'blue');
  }
  @HostListener ('mouseover') 
  onmouseover() {
    this.renderer.setStyle(this.elementRef.nativeElement, 'background-color' , 'red');
  }
  @HostListener ('mouseout')
  onmouseout() {
    this.renderer.setStyle(this.elementRef.nativeElement, 'background-color' , 'blue');
  }
}
