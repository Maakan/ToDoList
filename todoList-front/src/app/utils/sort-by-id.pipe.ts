import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sortById'
})
export class SortByIdPipe implements PipeTransform {
  transform(array: any[]): any[] {
    if (!Array.isArray(array)) {
      return array;
    }

    return array.sort((a, b) => b.index - a.index);
  }
}
