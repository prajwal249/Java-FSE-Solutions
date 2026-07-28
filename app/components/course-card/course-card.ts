import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../models/course.model';
import { HighlightDirective } from '../../directives/highlight.directive';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, HighlightDirective, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})

export class CourseCard implements OnChanges {
  @Input() course!: Course;
  @Output() enroll = new EventEmitter<number>();

  isExpanded = false;

  get cardClasses() {
    return {
      'card-enrolled': this.course?.enrolled,
      'card-full': this.course?.credits >= 4,
      expanded: this.isExpanded
    };
  }

  onEnroll() {
    this.enroll.emit(this.course.id);
  }

  toggleDetails() {
    this.isExpanded = !this.isExpanded;
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('Course changed:', changes['course']?.previousValue, '->', changes['course']?.currentValue);
  }
}