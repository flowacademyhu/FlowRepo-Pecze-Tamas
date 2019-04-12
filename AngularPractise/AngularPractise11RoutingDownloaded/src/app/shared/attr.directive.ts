import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appAttr]'
})
export class AttrDirective {
  constructor(private elementRef: ElementRef) {
    this.elementRef.nativeElement.BÁRAKÁRMI
  }
}