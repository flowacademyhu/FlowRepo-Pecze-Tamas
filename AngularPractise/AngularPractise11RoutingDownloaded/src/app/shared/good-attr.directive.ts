import { Directive, Renderer2, ElementRef, HostListener } from '@angular/core';
@Directive({
  selector: '[appGoodAttr]'
})
export class GoodAttrDirective {
  constructor(private elementRef: ElementRef, private renderer: Renderer2) {
  }

  // @HostListener('ESEMÉNY') metódus(eventData: Event) {

  // }

  @HostListener('mouseenter') mouseEnter(eventData: Event) {
    this.renderer.setStyle(this.elementRef.nativeElement, 'background-color', 'blue');
  }

  @HostListener('mouseleave') mouseLeave(eventData: Event) {
    this.renderer.setStyle(this.elementRef.nativeElement, 'background-color', 'transparent');
  }

}
